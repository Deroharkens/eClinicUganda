<!DOCTYPE html>
<html>
<head>
    <title>Book Appointment</title>
</head>
<body>
    <h2>Book Appointment</h2>
    <form action="../bookAppointment" method="post">
        <label>Patient ID:</label><br>
        <input type="text" name="patientId"><br>
        <label>Doctor ID:</label><br>
        <input type="text" name="doctorId"><br>
        <label>Date & Time (YYYY-MM-DD HH:MM:SS):</label><br>
        <input type="text" name="dateTime"><br><br>
        <input type="submit" value="Book">
    </form>
</body>
</html>
