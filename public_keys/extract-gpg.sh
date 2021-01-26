#!/bin/bash
# Tutorial: https://dev.to/vinitjogani/a-guide-to-git-secret-49g3
# set up a folder on our repo called public_keys and then added a 
# shell script to automatically import/export all keys as following 
# (fill $EMAIL with your local email used with your key, via a 
# shell argument perhaps)

gpg --import public_keys/* 
gpg --batch --yes -a -o public_keys/`echo $USER`.gpg --export $EMAIL
echo "Finished importing and exporting keys"
