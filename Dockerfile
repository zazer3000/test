FROM python:3.9
ADD app.py .
ADD requirements.txt .
EXPOSE 5000
RUN 'pip install --no-cache-dir -r ./requirements.txt'
ENTRYPOINT [“python3”, “./app.py”]
