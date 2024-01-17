using System.Net.Mail;
using System.Net;

namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        EmployeeService employeeService;
        DepartmentService departmentService;
        List<Department> departmentList;
        List<Employee> employeeList;
        public Form1()
        {
            InitializeComponent();
            employeeService = new EmployeeService();
            employeeService.createConnection();
            departmentService = new DepartmentService();
            departmentService.createConnection();

        }

        private void employeesButton_Click(object sender, EventArgs e)
        {
            var employeeList = employeeService.GetEmployees();

            comboBoxEmployees.DataSource = employeeList;
            comboBoxEmployees.DisplayMember = "name";
        }

        private void departmentsButton_Click(object sender, EventArgs e)
        {
            var departmentList = departmentService.GetAllDepartments();

            comboBoxDepartments.DataSource = departmentList;
            comboBoxDepartments.DisplayMember = "id";
        }

        private void emailButton_Click(object sender, EventArgs e)
        {
            // Assuming you have selected employees in the checkedListBox
            var selectedEmployees = checkedListBox.CheckedItems.Cast<Employee>().ToList();

            if (selectedEmployees.Count > 0)
            {
                try
                {
                    // Configure the SMTP client for Gmail
                    SmtpClient smtpClient = new SmtpClient("smtp.gmail.com");
                    smtpClient.Port = 587;
                    smtpClient.Credentials = new NetworkCredential("pm309963@gmail.com", "bfoh tbuj aqrc dfdc");;
                    smtpClient.EnableSsl = true;

                    // Sender's email address
                    string senderEmail = "pm309963@gmail.com";

                    foreach (var employee in selectedEmployees)
                    {
                        // Create a MailMessage
                        MailMessage mailMessage = new MailMessage(senderEmail, employee.email);
                        mailMessage.Subject = subjectTextBox.Text;
                        mailMessage.Body = bodyTextBox.Text;

                        // Send the email
                        smtpClient.Send(mailMessage);

                        // Optional: Display a success message or perform any additional actions
                    }

                    labelEmailStatus.Text = "Emails sent successfully!";
                }
                catch (Exception ex)
                {
                    labelEmailStatus.Text = $"Error sending emails: {ex.Message}";
                }
            }
            else
            {
                labelEmailStatus.Text = "No employees selected";
            }
        }

        private void showEmpByDeptButton_Click(object sender, EventArgs e)
        {
            var employeeList = employeeService.GetAllEmployeesPerDepartment(comboBoxDepartments.Text);

            checkedListBox.DataSource = employeeList;
            checkedListBox.DisplayMember = "name";
        }

        private void showManByDeptButton_Click(object sender, EventArgs e)
        {
            var employeeList = employeeService.GetAllManagersPerDepartment(comboBoxDepartments.Text);

            checkedListBox.DataSource = employeeList;
            checkedListBox.DisplayMember = "name";
        }
    }
}