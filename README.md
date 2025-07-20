# sweeps_work
Project Work for SWEEPS (Secure Engineering) Program with UC Davis

<code>
module4/
│
├── passhash.py              # ← GUI app (Tkinter + logic)
├── password_utils.py        # ← Core logic (hashing, verifying)
├── test_password_utils.py   # ← Unit tests for password_utils
└── requirements.txt         # ← dependencies (like argon2-cffi)
</code>

<br>
How to use requirements.txt:

<code> pip install -r requirements.txt</code>


Test "module 4" works:

<code>python passhash.py</code>        # runs your GUI

<code>python test_password_utils.py</code>   # runs your unit tests


### 💡 Troubleshooting
If you get an error like `ModuleNotFoundError: No module named 'argon2'`:

Try installing pip (if not present):
```bash
python -m ensurepip --upgrade

