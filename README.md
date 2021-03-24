<h1># medicalClinic </h1>

We have a small health clinic where the following people can be employed:

<ul>
  <li>Office Workers</li>
  <li>Medical Workers</li>
    <ul>
        <li>Doctors - Pediatricians and Internists</li>
        <li>Nurses</li>
    </ul>
</ul>

We have the following data about each employee:

<ul>
    <li>Employee code</li>
    <li>Name</li>
    <li>Surname</li>
    <li>Date of birth</li>
    <li>Hire date</li>
    <li>Salary</li>
</ul>

Additionally, the medical staff does
<li>Medical license number</li>

Office staff can:
<ul>
<li>Register the visit</li>
<li>Ask for the patient's name</li>
<li>Ask for his date of birth.</li>
<li>Ask about the purpose of the visit. The patient tells how many medical procedures he will have and then gives them one by one (available medical procedures below)
<li>Record the visit, i.e. write out information about it and save it in the log</li>
<li>Transfer the patient to the appropriate person from the medical staff, i.e. if the purpose of the visit can be achieved by the nurse (she can perform all the procedures selected by the patient), then we assign the patient to the patient, if only by a doctor, then we choose the appropriate doctor depending on the age (less than 18 years old pediatrician, more internist)</li>
<li>Calculate the salary of a given employee from the beginning of employment</li>
<li>List how long the employee has been working in the clinic</li>
<li>Write out information about the employee.</li>
</ul>

Medical Worker can:
<ul>
    <li>Execute medical procedure:</li>
    <ul>
        <li>Prints to console and to log file information who executed the procedure and on which patient</li>
    </ul>
</ul>

List of medical procedures: 
<ul>
    <li>Injection</li>
    <li>Weight measurement</li>
    <li>Pressure measurement</li>
    <li>Blood collection</li>
    <li>General check up (Doctor only)</li>
    <li>Ultrasound examination (Doctor only)</li>
    <li>Writing a prescription (Doctor only)</li>
</ul>


The principle of operation of the program:
<ul>
<li>Register the visit: then the program asks us to provide patient data as well as the number and numbers of medical procedures. After receiving them, he registers the visit and forwards it to the appropriate person from the medical staff.</li>
<li>Calculate the salary of a given employee from the beginning of employment - then the program asks us to enter the employee's code.</li>
<li>List how long the employee has been working in the clinic - then the program asks you to enter the employee code.</li>
<li>Write out information about a given employee - then the program asks us to enter the employee's code.</li>
</ul>



