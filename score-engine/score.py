from ocr import extract_text, extract_ingredients

def score_product(uri):
    text = extract_text(uri)
    name, ingredients = extract_ingredients(text)

    score = 1.
    cnt = 1
    lst = []

    with conn.cursor() as cursor:
        for x in ingredients:
            found = False
            for el in [x[0]] + x[1]:
                result = cursor.execute(f"SELECT score, details FROM ingredients WHERE LOCATE('{el.lower()}', LOWER(name)) > 0 OR LOCATE(LOWER(name), '{el.lower()}') > 0;")
                data = cursor.fetchall()
                if result > 0:
                    for d in data[:1]:
                        score += d['score']
                        cnt += 1
                        lst.append({"name": x[0], "score": f"{d['score'] * 100}%", "description": d["details"]})
                        found = True
                if found:
                    break
            if not found:
                score += 1
                cnt += 1
                lst.append({"name": x[0], "score": "100%", "description": ""})
    conn.close()
    score = score / cnt

    return {
        "name": name,
        "score": f'{score * 100}%',
        "ingredients": dic
    }