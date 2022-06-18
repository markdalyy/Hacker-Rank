import re

regularExpression = '^a([ab]*a)?$|^b([ab]*b)?$'
#regularExpression = '^(\w)(\w*\1)?$'
#regularExpression = '^[a-z]$|^([a-z]).*\1$'
pattern = re.compile(regularExpression)

if pattern.match('aba'):
    print(True)
else:
    print(False)
