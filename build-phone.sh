#!/data/data/com.termux/files/usr/bin/bash
set -e
printf '\nMSN-GUARD+ phone build helper\n\n'
if ! command -v git >/dev/null 2>&1; then
  echo 'Installing git...'
  pkg update -y
  pkg install -y git
fi

echo '1) Create an empty GitHub repository from your phone.'
echo '2) Then enter its HTTPS URL below.'
read -r -p 'GitHub repository URL: ' REPO
if [ -z "$REPO" ]; then echo 'No repository URL.'; exit 1; fi

DIR="$HOME/MSN-GUARD-PLUS"
rm -rf "$DIR"
mkdir -p "$DIR"
# This script is intended to be run from the extracted project directory.
cp -a . "$DIR/"
cd "$DIR"
git init
git add .
git -c user.name='MSN-GUARD+ Builder' -c user.email='builder@localhost' commit -m 'Phone build'
git branch -M main
git remote add origin "$REPO"
echo
 echo 'Now GitHub will ask for authentication. Use your GitHub username and a Personal Access Token as the password.'
git push -u origin main

echo
 echo 'Open GitHub -> Actions -> Build MSN-GUARD+ -> Run workflow.'
echo 'After it finishes, open the run and download MSN-GUARD-PLUS-debug-apk.'
