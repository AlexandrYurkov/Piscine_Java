cd ~/%ImagesToChar%/
mkdir target && mkdir target/edu.school21.printer
javac -d target/edu.school21.printer src/java/edu.school21.printer/app/* src/java/edu.school21.printer/logic/*
java -classpath target/edu.school21.printer src.java.edu.school21.printer.app.App src/it.bmp