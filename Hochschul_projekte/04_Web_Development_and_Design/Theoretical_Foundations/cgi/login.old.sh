#!/usr/bin/env bash

echo "Content-type: text/plain"
echo ""


email=$(echo "$QUERY_STRING" | cut -d';' -f1 | sed "s/email=//g") #| sed 's/%40/@/g')
password=$(echo "$QUERY_STRING" | cut -d';' -f2 | sed "s/password=//g")
#echo "$email"

stored_email=$(mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "select email from user_data where email='$email';")
stored_email=$(echo "$stored_email" | sed 's/%40/@/g')
#echo "$stored_email"
if [[ -n "$stored_email" ]] && [[ "$stored_email" == "$email" ]]; then

  stored_password=$(mariadb --defaults-file=/var/www/html/private/mariadb-defaults.cnf -s -e "select password from user_data where email='$email';")

if [[ "$stored_password" == "$password" ]]; then
  session_id=$(pwgen 40 1)

  mkdir -p "/tmp/$session_id"

  #echo "eingeloggt"

  set-cookie: session_id=$session_id; HttpOnly; Secure
  echo "$session_id:$email" >> /tmp/sessions.txt

  echo "eingeloggt"

else

  echo "E-Mail oder Passwort falsch"

fi
else
  echo "Du bist hier falsch"
fi