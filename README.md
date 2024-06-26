# Git Global Setup
```bash
git config --global user.name "[CLOUD4] 김다애"
git config --global user.email "wlsemrdl1212@naver.com"
Create a New Respotiory
git clone https://kdt-gitlab.elice.io/cloud_track/class_04/class_041/project/daae-java-practice.git
cd daae-java-practice
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master
# Push an Existing Folder
cd existing_folder
git init
git remote add origin https://kdt-gitlab.elice.io/cloud_track/class_04/class_041/project/daae-java-practice.git
git add .
git commit -m "Initial commit"
git push -u origin master

# intellij로 커밋을해보자2