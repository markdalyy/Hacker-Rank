import re

def timeConversion(s):
    """
    period = s[-2::]
    s = s[:-2]
    s = s.split(":")

    if period == "PM":
        if s[0] != "12":
            s[0] = str(int(s[0])+12)
    else:
        if s[0] == "12":
            s[0] = "00"
    s = ":".join(s)
    return s
    """

    period = re.search(r"\w\w$", s).group()
    hour = int(s[:2])
    s = re.sub(r"\w\w$", "", s)

    if period == "PM":
        if hour != 12:
            s = re.sub(r"^\d+", str(hour + 12), s)
    else:
        if s.startswith("12"):
            s = s.replace("12", "00", 1)

    return s


timeConversion("12:01:00PM")
