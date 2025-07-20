#The PassHash program is intended to take a password input from the user and apply a hashing algorithim (Argon2) and a salt.
# PassHash will output the password in plaintext and the hash in hexadecimal.

#import required packages
from argon2 import PasswordHasher
from tkinter import Tk, Label, Entry, Button, StringVar
from argon2.exceptions import VerifyMismatchError

# bring in unit testing library items
from password_utils import hash_password, verify_password

# Argon2 package hasher
ph = PasswordHasher()

# For this academic proof-of-concept; store the plaintext and hash in memory
password_plaintext = ""
password_hash = ""
verify_attempt = ""
verify_result = None

# Adding GUI logic
def get_password():
    global password_plaintext, password_hash
    password_plaintext = password_var.get()
    password_hash = hash_password(password_plaintext)
    root1.destroy()  # Closes the window after entry

# GUI window
root1 = Tk()
root1.title("Enter a Password")

# Label, Entry and a Submit button
Label(root1, text="Enter your password:").pack(pady=5)
password_var = StringVar()
Entry(root1, textvariable=password_var, show="*").pack(pady=5)
Button(root1, text="Submit", command=get_password).pack(pady=10)

# Run the GUI loop
root1.mainloop()

# ---test-specific GUI--
def verify_pass():
    global verify_attempt, verify_result
    verify_attempt = verify_var.get()
    try:
        ph.verify(password_hash, verify_attempt)
        verify_result = True
    except VerifyMismatchError:
        verify_result = False
    root2.destroy()

root2 = Tk()
root2.title("Verify Password")

Label(root2, text="Re-enter your password:").pack(pady=5)
verify_var = StringVar()
Entry(root2, textvariable=verify_var, show="*").pack(pady=5)
Button(root2, text="Verify", command=verify_pass).pack(pady=10)

root2.mainloop()

# Output Results --
print("\n🔐 Test Summary")
print("--------------------------")
print("Original Plaintext Password:", password_plaintext)
print("Argon2 Hash:", password_hash)
print("Verification Attempt:", verify_attempt)
print("Match Result:", "Issa match!" if verify_result else "Isnotta match!")

# Run the tests with 
# python test_password_utils.py

##- Python Terminal Only Version (remove tkinter package import)
# Prompt user for input
# password = input("Enter any password: ")

# Hash the user's password
# hash = ph.hash(password)

# Output of te plaintext and hash value
# print("Plaintext:", password)
# print("Argon2 Hash:", hash)

# Test scenarios:
# 1 ---- an input of password, displaying the output of "password"
# password_plaintext = password_var.get()
# print("Original Plaintext Password:", password_plaintext)

# a second input of password, displaying the output of "password" with a new hash value
# password_hash = ph.hash(password_plaintext)
# print("Argon2 Hash:", password_hash)

# a verification test case for metadata used by Argon2, using the verify() method
# check = input("Reenter your password to verify: ")

# try:
#    ph.verify(hash, password)
#    print("Good to go!")
#except:
#    print("No dice.")
