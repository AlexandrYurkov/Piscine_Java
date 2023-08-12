cd ~/%ImagesToChar%/
mkdir target/
javac -d target/ src/edu.school21.printer/app/* src/edu.school21.printer/logic/*
java -classpath target/ edu.school21.printer.app.App src/it.bmp