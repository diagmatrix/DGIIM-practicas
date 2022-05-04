#!/bin/bash

echo "Compilando apuntes..."
pandoc empresa_apuntes.md --template ies.template -V lang=es --from markdown -o empresa_apuntes.pdf
echo "Hecho!"