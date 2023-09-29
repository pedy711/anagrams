# Anagrams Service

The Anagrams Service provides two key functionalities:

1. **Anagram Detection**: It checks whether two given texts are 
anagrams of each other.

2. **Indirect Anagram Detection**: It can identify anagrams of a 
text even if that text was not directly compared to all of its potential anagrams. However, the text must have been checked against at least one anagram in the initial anagram detection step.

## Design Patterns Utilized

This service utilizes two design patterns to achieve its 
functionality:

- **Bill Pugh Singleton Pattern**: This pattern ensures that only
one instance of the Anagram class is created, promoting efficient resource usage and maintaining a single point of access for anagram-related operations.

- **Observer Pattern**: The Observer pattern is employed to 
keep all anagrams updated, even if they were not directly 
compared to each other. When an anagram relationship is 
established between two texts, the Observer pattern facilitates
the propagation of this relationship to other potential anagrams. 
This ensures comprehensive anagram detection and a seamless user
experience.
