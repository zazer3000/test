FROM python:3.9
ADD app.py .
EXPOSE 5000
RUN 'pip install -r ./requirements.txt'
ENTRYPOINT [“python3”, “./app.py”]
