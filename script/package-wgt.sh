#!/bin/sh

set -e

SECURITY_PROFILE=dev
OUTPUT_DIR=tizen/out/
CONFIG_DIR=tizen/

rm -rf $OUTPUT_DIR/*

tizen package --type wgt \
              --sign $SECURITY_PROFILE \
              --output $OUTPUT_DIR \
              -- $CONFIG_DIR