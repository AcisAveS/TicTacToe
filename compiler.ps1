javac -d  bin ./src/Main.java ./src/Views/*.java ./src/Controllers/*.java;
jar cfm TicTacToe.jar MANIFEST.MF -C bin/ .