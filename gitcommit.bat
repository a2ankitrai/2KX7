@ECHO OFF 

git add .
echo Staging newly added or modified files
pause

git commit -m "updated files"
echo Commiting to local repository
pause

git config user.name "a2ankitrai"
git config user.email a2.ankitrai@gmail.com
echo Configuring git username and user email
pause

git push origin master
echo pushing to remote repository
pause
