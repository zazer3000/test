FROM python:3
ADD app.py .
ADD requirements.txt .
EXPOSE 5000
RUN pip install --no-cache-dir -r requirements.txt
CMD [ "python", "./app.py" ]
