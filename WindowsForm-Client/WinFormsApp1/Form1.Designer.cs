namespace WinFormsApp1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            comboBoxEmployees = new ComboBox();
            label1 = new Label();
            employeesButton = new Button();
            emailButton = new Button();
            departmentsButton = new Button();
            label2 = new Label();
            comboBoxDepartments = new ComboBox();
            showEmpByDeptButton = new Button();
            checkedListBox = new CheckedListBox();
            showManByDeptButton = new Button();
            label3 = new Label();
            subjectTextBox = new TextBox();
            label4 = new Label();
            bodyTextBox = new RichTextBox();
            labelEmailStatus = new Label();
            SuspendLayout();
            // 
            // comboBoxEmployees
            // 
            comboBoxEmployees.FormattingEnabled = true;
            comboBoxEmployees.Location = new Point(22, 29);
            comboBoxEmployees.Margin = new Padding(3, 2, 3, 2);
            comboBoxEmployees.Name = "comboBoxEmployees";
            comboBoxEmployees.Size = new Size(133, 23);
            comboBoxEmployees.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(22, 9);
            label1.Name = "label1";
            label1.Size = new Size(64, 15);
            label1.TabIndex = 1;
            label1.Text = "employees";
            // 
            // employeesButton
            // 
            employeesButton.Location = new Point(161, 30);
            employeesButton.Margin = new Padding(3, 2, 3, 2);
            employeesButton.Name = "employeesButton";
            employeesButton.Size = new Size(161, 22);
            employeesButton.TabIndex = 2;
            employeesButton.Text = "load Employees";
            employeesButton.UseVisualStyleBackColor = true;
            employeesButton.Click += employeesButton_Click;
            // 
            // emailButton
            // 
            emailButton.Location = new Point(382, 281);
            emailButton.Margin = new Padding(3, 2, 3, 2);
            emailButton.Name = "emailButton";
            emailButton.Size = new Size(115, 46);
            emailButton.TabIndex = 4;
            emailButton.Text = "send emails";
            emailButton.UseVisualStyleBackColor = true;
            emailButton.Click += emailButton_Click;
            // 
            // departmentsButton
            // 
            departmentsButton.Location = new Point(161, 88);
            departmentsButton.Margin = new Padding(3, 2, 3, 2);
            departmentsButton.Name = "departmentsButton";
            departmentsButton.Size = new Size(161, 22);
            departmentsButton.TabIndex = 5;
            departmentsButton.Text = "load Departments";
            departmentsButton.UseVisualStyleBackColor = true;
            departmentsButton.Click += departmentsButton_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(22, 72);
            label2.Name = "label2";
            label2.Size = new Size(74, 15);
            label2.TabIndex = 6;
            label2.Text = "departments";
            // 
            // comboBoxDepartments
            // 
            comboBoxDepartments.FormattingEnabled = true;
            comboBoxDepartments.Location = new Point(22, 89);
            comboBoxDepartments.Margin = new Padding(3, 2, 3, 2);
            comboBoxDepartments.Name = "comboBoxDepartments";
            comboBoxDepartments.Size = new Size(133, 23);
            comboBoxDepartments.TabIndex = 7;
            // 
            // showEmpByDeptButton
            // 
            showEmpByDeptButton.Location = new Point(348, 29);
            showEmpByDeptButton.Margin = new Padding(3, 2, 3, 2);
            showEmpByDeptButton.Name = "showEmpByDeptButton";
            showEmpByDeptButton.Size = new Size(164, 78);
            showEmpByDeptButton.TabIndex = 8;
            showEmpByDeptButton.Text = "show Employees in selected Department";
            showEmpByDeptButton.UseVisualStyleBackColor = true;
            showEmpByDeptButton.Click += showEmpByDeptButton_Click;
            // 
            // checkedListBox
            // 
            checkedListBox.FormattingEnabled = true;
            checkedListBox.Location = new Point(439, 112);
            checkedListBox.Name = "checkedListBox";
            checkedListBox.Size = new Size(146, 148);
            checkedListBox.TabIndex = 9;
            // 
            // showManByDeptButton
            // 
            showManByDeptButton.Location = new Point(524, 30);
            showManByDeptButton.Margin = new Padding(3, 2, 3, 2);
            showManByDeptButton.Name = "showManByDeptButton";
            showManByDeptButton.Size = new Size(164, 77);
            showManByDeptButton.TabIndex = 10;
            showManByDeptButton.Text = "show Managers in selected Department";
            showManByDeptButton.UseVisualStyleBackColor = true;
            showManByDeptButton.Click += showManByDeptButton_Click;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(18, 132);
            label3.Name = "label3";
            label3.Size = new Size(78, 15);
            label3.TabIndex = 11;
            label3.Text = "email Subject";
            // 
            // subjectTextBox
            // 
            subjectTextBox.Location = new Point(22, 159);
            subjectTextBox.Name = "subjectTextBox";
            subjectTextBox.Size = new Size(245, 23);
            subjectTextBox.TabIndex = 12;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(18, 203);
            label4.Name = "label4";
            label4.Size = new Size(66, 15);
            label4.TabIndex = 13;
            label4.Text = "email Body";
            // 
            // bodyTextBox
            // 
            bodyTextBox.Location = new Point(22, 230);
            bodyTextBox.Name = "bodyTextBox";
            bodyTextBox.Size = new Size(245, 96);
            bodyTextBox.TabIndex = 14;
            bodyTextBox.Text = "";
            // 
            // labelEmailStatus
            // 
            labelEmailStatus.AutoSize = true;
            labelEmailStatus.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point);
            labelEmailStatus.Location = new Point(273, 258);
            labelEmailStatus.Name = "labelEmailStatus";
            labelEmailStatus.Size = new Size(160, 21);
            labelEmailStatus.TabIndex = 15;
            labelEmailStatus.Text = "email Status Waiting...";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(700, 338);
            Controls.Add(labelEmailStatus);
            Controls.Add(bodyTextBox);
            Controls.Add(label4);
            Controls.Add(subjectTextBox);
            Controls.Add(label3);
            Controls.Add(showManByDeptButton);
            Controls.Add(checkedListBox);
            Controls.Add(showEmpByDeptButton);
            Controls.Add(comboBoxDepartments);
            Controls.Add(label2);
            Controls.Add(departmentsButton);
            Controls.Add(emailButton);
            Controls.Add(employeesButton);
            Controls.Add(label1);
            Controls.Add(comboBoxEmployees);
            Margin = new Padding(3, 2, 3, 2);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox comboBoxEmployees;
        private Label label1;
        private Button employeesButton;
        private Button emailButton;
        private Button departmentsButton;
        private Label label2;
        private ComboBox comboBoxDepartments;
        private Button showEmpByDeptButton;
        private CheckedListBox checkedListBox;
        private Button showManByDeptButton;
        private Label label3;
        private TextBox subjectTextBox;
        private Label label4;
        private RichTextBox bodyTextBox;
        private Label labelEmailStatus;
    }
}