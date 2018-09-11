# intscribe
Accepts an integer between -999,999 and 999,999 and outputs a string representation of the value in English.

#### INSTRUCTIONS:
Navigate to the jar located in the out folder.

```sbtshell
project/root $ cd out/artifacts/intscribe_jar
```

Run the jar as follows:
```sbtshell
$ java -jar intscribe.jar <integer>

e.g.

$ java -jar intscribe.jar 100
$ java -jar intscribe.jar 123456
$ java -jar intscribe.jar -100
$ java -jar intscribe.jar -999999
```

#### ASSUMPTIONS:
- It was okay to name the project intscribe instead of ConvertNumber.

- Only integers will be fed to the jar. It will handle out of range values, but non-integers will throw an exception. Bad inputs could obviously be dealt with pretty easily, but I'm making the assumption that this was not an important part of the task. If that is an incorrect assumption, I would be happy to add in better handling of destructive testing.

- I tested pulling down the repository and running the intscribe.jar located in the out folder and it worked for me, so I'm assuming it should work for you as well. If it doesn't, let me know and I'll get you the files some other way.
