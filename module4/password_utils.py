# password_utils.py

from argon2 import PasswordHasher
from argon2.exceptions import VerifyMismatchError

ph = PasswordHasher()

def hash_password(plaintext: str) -> str:
    return ph.hash(plaintext)

def verify_password(stored_hash: str, attempt: str) -> bool:
    try:
        return ph.verify(stored_hash, attempt)
    except VerifyMismatchError:
        return False
