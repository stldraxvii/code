import hashlib
import hmac

SECRET = "sososecret"

def hash_str(s):
    return hmac.new(SECRET, s).hexdigest()

def make_secure_val(s):
    hash = hash_str(s)
    return (s+"|"+hash)

def check_secure_val(h):
    val = h.split("|")[0]
    if h == make_secure_val(val):
        return val
