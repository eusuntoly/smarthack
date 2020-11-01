import io
import os
from google.cloud import vision
os.environ["GOOGLE_APPLICATION_CREDENTIALS"]="key.json"

def extract_text(uri):
    client = vision.ImageAnnotatorClient()
    image = vision.Image()
    image.source.image_uri = uri

    response = client.text_detection(image=image)
    texts = response.text_annotations

    for text in texts:
        return text.description

    if response.error.message:
        print(
            f'{response.error.message}\nFor more info on error messages,'
            ' check: https://cloud.google.com/apis/design/errors')


def extract_ingredients(text):
    print(text)
    text = text.replace("\n", " ")
    p1 = text.find("GB")
    while text[p1] != ' ':
        p1 += 1
    p2 = text.lower().find("ingredients")
    name = text[p1 : p2].strip().upper()

    text = text[p2 + 13:]
    p = text.find(". ")
    text = text[:p]
    parts = [x.strip() for x in text.split(", ")]

    ingredients = []
    for x in parts:
        p = x.find("(")
        if p > 0:
            aliases = [el.strip() for el in x[p + 1 : -1].split(", ")]
            ingredients.append((x[:p].strip(), aliases))
        else:
            ingredients.append((x, []))
    
    return name, ingredients