mkdir -p target && mkdir -p target/resources
cp src/resources/it.bmp target/resources/
javac -d target/ src/java/edu/school21/printer/app/App.java src/java/edu/school21/printer/logic/Logic.java
jar cvfm target/images-to-chars-printer.jar ./src/manifest.txt -C ./target/ ./src/java/edu/school21/printer/
java -jar ./target/images-to-chars-printer.jar