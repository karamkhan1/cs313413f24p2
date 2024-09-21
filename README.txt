Q - Does using a LinkedList instead of an ArrayList make any difference?
A - When you switch from an ArrayList to a LinkedList, the main impact is on performance. LinkedList excels at adding or removing elements, particularly at the beginning or middle, because it doesn’t need to shift elements like an ArrayList. However, if you prefer to access elements by index which is the general case, ArrayLists are faster because it provides direct access, whereas LinkedList requires that you traverse nodes sequentially.

Q - What happens if you use list.remove(Integer.valueOf(77)) instead of i.remove()?
A - Using i.remove() is ideal within a loop because it safely removes the current element from the iterator’s perspective, helping to avoid any type of ConcurrentModificationException errors. On the other hand, list.remove(Integer.valueOf(77)) removes the first occurrence of 77 from the list, independent of the iterator's position. This can get messy in the iteration flow and most likley lead to errors.

Q - Differences between list.remove(5) and list.remove(Integer.valueOf(5)).
A - list.remove(5) removes the element at index 5, while, list.remove(Integer.valueOf(5)) searches for and removes the first occurrence of the value 5. 