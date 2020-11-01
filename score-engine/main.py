from flask import Flask, request, jsonify
from score import score_product


app = Flask(__name__)

@app.route('/score', methods=['POST'])
def score():
    content = request.json
    return jsonify(
        score_product(content['link'])
    )

if __name__ == '__main__':
    app.run(threaded=True)