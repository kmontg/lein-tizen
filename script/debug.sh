#!/bin/sh

set -e

APP_ID=MRaYAsPdtB.leintizen
LOCAL_PORT=11223

sdb shell "app_launcher --kill $APP_ID"
REMOTE_PORT=`sdb shell "app_launcher --web-debug --start $APP_ID" | sed -n -e "s/^.*port: //p" | tr -d '\r'`

echo "Forwarding debugging port: (local):$LOCAL_PORT -> (remote):$REMOTE_PORT"
sdb forward --remove-all
sdb forward tcp:$LOCAL_PORT tcp:$(echo $REMOTE_PORT)

# TODO: Open Google Chrome to the local port