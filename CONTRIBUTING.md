If you would like to contribute to this project, please follow general contributing guidelines of other open source projects. Here are some general things that get on my nerves, so please follow these:
```java
// Spacing after if
if (true) {
    System.out.println("Thank you for formatting properly");
}
if(false) {
    System.out.println("You formatted wrong");
}

// Also empty brackets should be closed not expanded:
public Contructor(String string, int integer) {}
try { 
    File file = new File("CONTRIBUTING.md");
} catch (PeopleNotFollowingGuidelinesException ignored) {}

// Also comments should have a space after the // and have proper capitlization
//so not like this
// But like this
```
Thanks! We are always open to PRs that add new features. The "servers" folder is in the .gitignore so you can do testing in there.
