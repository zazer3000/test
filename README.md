Machine used - Debian 12 on VirtualBox
App was generated with AI
1. Jenkins was installed from tutorial (https://medium.com/@redswitches/how-to-install-jenkins-on-debian-12-in-6-steps-35b999501b4a)
   Pipeline added and contains 3 steps and triggered manually after any changes to Dockerfile
   - build step builds image from Dockerfile. File itself in root path of the repo;
   - deploy stopping previously running containers and start new one;
   - test that app returns "hello" massage. Implemented with curl & grep
![image](https://github.com/user-attachments/assets/95ea7c96-a093-40c4-a461-388f3101f6a8)
   Repo contains 2 groovy files. One for job DSL another for pipeline

2. Monitoring
   Grafana was installed from official tutorial
   prometheus and cadvisor deployment goes through docker compose. Compose file in the root of repo
   dashboard imported from grafanalabs (dashboard id 14282). While importing dashboard prom source was added. And grafana begin to scrape data from prom instance
![image](https://github.com/user-attachments/assets/7d5f9fa8-5ede-42ae-a368-2c781f71da48)

   then with "..." -> more -> new alert rule, alert rules was added. One for CPU in %, other for Mem in KB. If metric goes above some value rule become to fire and send
       a message to e-mail. Message was not modified.
![image](https://github.com/user-attachments/assets/08535bdc-c357-4ac5-89f5-a1452acf26b7)

   For system monitoring I used Node exporter and dashboard 1860
   ![image](https://github.com/user-attachments/assets/3c846ff5-66cd-4ee4-b5bb-8425a1ad9a26)
