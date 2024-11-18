Q)1 
from collections import Counter
d1 = {'a': 100, 'b': 200, 'c': 300}
d2 = {'a': 300, 'b': 200, 'd': 400}
result = Counter(d1) + Counter(d2)
print(result)


Q.2 Write a Python program for dynamic implementation of Singly Linked List to perform 
following operations: 
a. Create
b. Display
 c. Sort

 Ans -  class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def create(self, data_list):
        for data in data_list:
            new_node = Node(data)
            if not self.head:
                self.head = new_node
            else:
                current = self.head
                while current.next:
                    current = current.next
                current.next = new_node

    def display(self):
        current = self.head
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

    def sort(self):
        if not self.head or not self.head.next:
            return
        current = self.head
        while current:
            index = current.next
            while index:
                if current.data > index.data:
                    current.data, index.data = index.data, current.data
                index = index.next
            current = current.next

# Example usage:
sll = SinglyLinkedList()
sll.create([3, 1, 4, 2])
print("Linked List before sorting:")
sll.display()
sll.sort()
print("Linked List after sorting:")
sll.display()
