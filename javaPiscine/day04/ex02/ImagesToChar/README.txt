mkdir lib && mkdir target && mkdir target/resources;
cd lib && { curl -O https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar -O https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar; cd ..;};
cp src/resources/it.bmp target/resources/ ;
cd target && jar xf ../lib/jcommander-1.82.jar com && jar xf ../lib/JCDP-4.0.2.jar com && cd .. ;
javac -d target/ -classpath ./lib/\* src/java/edu/school21/printer/app/*.java src/java/edu/school21/printer/logic/*.java
jar cvfm target/images-to-chars-printer.jar ./src/manifest.txt -C ./target/ . && java -jar ./target/images-to-chars-printer.jar --white=GREEN --black=RED