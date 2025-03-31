from flask import Flask, jsonify

# Initialize the Flask app
app = Flask(__name__)

# Create an API endpoint
@app.route('/api/hello', methods=['GET'])
def hello_world():
    # Return a JSON response
    return jsonify({"message": "Hello, World!"})

# Run the app
if __name__ == '__main__':
    app.run(debug=True)
