import math


def getSmallestClockAngle(timeString, unit):
    hour = int(timeString[:2])
    mins = int(timeString[3:])
    if unit == 'degrees':
        sector = 30
    else:
        sector = math.pi / 3
    hr_angle = hour * (sector) + mins / 2
    mins_angle = mins * (sector / 5)
    angle = abs(hr_angle - mins_angle)
    if unit == 'degrees':
        # angle = min(360-angle, angle)
        return angle % 180
    else:
        if angle == math.pi:
            return round(math.pi / 2, 4)
        angle = round(angle, 4)
        return angle % math.pi
