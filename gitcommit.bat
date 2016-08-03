@ECHO OFF 

git add .
echo Staging newly added or modified files... 

git commit -m "updated files"
echo Commiting to local repository....


git config user.name "a2ankitrai"
git config user.email a2.ankitrai@gmail.com
echo Configuring git username and user email...

git push origin master
echo pushing to remote repository...

