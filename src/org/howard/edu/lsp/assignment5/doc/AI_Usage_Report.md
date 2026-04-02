 AI Usage Report

Prompt:  How do I implement a union method for a set of integers in Java using ArrayList without duplicates?  
 Response: Create a new set, add all elements from the first set, then loop through the second set and add any elements not already present.  
Applied in code: `union(IntegerSet b)` method.

Prompt : How do I implement an intersection method for a set of integers that returns only common elements?  
AI Response: Loop through elements of the first set and add them to a new set only if they exist in the second set.  
Applied in code: `intersect(IntegerSet b)` method.

Prompt 3: How do I prevent duplicates when adding an item to an ArrayList-based set?  
AI Response: Use `contains` to check if the item already exists before adding it.  
Applied in code: `add(int item)` method.