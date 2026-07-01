#!/usr/bin/env bash
set -euo pipefail

echo "Running performance tests"

# Placeholder performance test command.
# Replace with the real command when available.
mvn -B test -Dtest=Performance* --file pom.xml
