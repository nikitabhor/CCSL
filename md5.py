import hashlib

str1 = input("Enter the string: ")
str2 = input("Enter the string: ")

result1 = hashlib.md5(str1.encode())
result2 = hashlib.sha256(str1.encode())


print("The hexadecimal equivalent of hash is  for md5: ")
print(result1.hexdigest())

print("The hexadecimal equivalent of hash is  for sha: ")
print(result2.hexdigest())