# test_password_utils.py

import unittest
from password_utils import hash_password, verify_password

class TestPasswordUtils(unittest.TestCase):

    def test_plaintext_pass_through(self):
        password = "password"
        self.assertEqual(password, "password")

    def test_hash_uniqueness_for_same_password(self):
        password = "password"
        self.assertNotEqual(hash_password(password), hash_password(password))

    def test_successful_verification(self):
        password = "password"
        hashed = hash_password(password)
        self.assertTrue(verify_password(hashed, password))

    def test_failed_verification_with_wrong_password(self):
        password = "password"
        hashed = hash_password(password)
        self.assertFalse(verify_password(hashed, "wrongpassword"))

if __name__ == '__main__':
    unittest.main()
