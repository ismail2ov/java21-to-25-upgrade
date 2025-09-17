
/// 1. Compile the Java file
/// ~~~
/// $ javac -d target src/main/java/com/github/ismail2ov/java25/HelloWorld.java
/// ~~~
///
/// 2. Run the compiled code
/// ~~~
/// $ java -cp target HelloWorld
/// ~~~
///
/// 3. View the contents of the .class file
/// ~~~
/// $ javap -c -cp target HelloWorld
/// ~~~
void main() {
    IO.println("Hello, World!");
}