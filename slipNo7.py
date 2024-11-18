class Stack:
    def __init__(self):
        self.items = []
    
    def push(self, item):
        self.items.append(item)
    
    def pop(self):
        if not self.is_empty():
            return self.items.pop()
        return None
    
    def is_empty(self):
        return len(self.items) == 0

def is_palindrome(string):
    stack = Stack()
    # Preprocess the string: Remove spaces and convert to lowercase for uniformity
    string = ''.join(string.split()).lower()

    # Push all characters of the string onto the stack
    for char in string:
        stack.push(char)
    
    # Build the reversed string using the stack
    reversed_string = ""
    while not stack.is_empty():
        reversed_string += stack.pop()
    
    # Check if the original string is the same as the reversed string
    return string == reversed_string

# Input from the user
string = input("Enter a string: ")
if is_palindrome(string):
    print(f'"{string}" is a palindrome.')
else:
    print(f'"{string}" is not a palindrome.')




Q.2 Write a Python program for dynamic implementation of linear queue to perform following 
operations:
a. init
b. enqueue
c. dequeue
d. isEmpty

ans - 


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.front = None
        self.rear = None

    def isEmpty(self):
        return self.front is None

    def enqueue(self, data):
        new_node = Node(data)
        if self.rear is None:
            self.front = self.rear = new_node
            return
        self.rear.next = new_node
        self.rear = new_node

    def dequeue(self):
        if self.isEmpty():
            return "Queue is empty"
        temp = self.front
        self.front = temp.next
        if self.front is None:
            self.rear = None
        return temp.data


q = Queue()
q.enqueue(10)
q.enqueue(20)
print(q.dequeue())  
print(q.isEmpty()) 
print(q.dequeue())  
print(q.isEmpty()) 
