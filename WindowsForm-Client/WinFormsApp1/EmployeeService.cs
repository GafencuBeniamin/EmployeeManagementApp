using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace WinFormsApp1
{
    internal class EmployeeService
    {
        static HttpClient client = new HttpClient();

        public void createConnection()
        {
            // Update port # in the following line.
            client.BaseAddress = new Uri("http://localhost:8080/");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(
                new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public List<Employee> GetEmployees()
        {
            List<Employee> employees = null;
            HttpResponseMessage response = client.GetAsync("employees").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Console.WriteLine("gata : " + resultString);
                employees = JsonSerializer.Deserialize<List<Employee>>(resultString);
                return employees;
            }
            return null;
        }
        public Employee GetEmployeeById(int id)
        {
            Employee employee = null;
            HttpResponseMessage response = client.GetAsync($"employees/{id}").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                employee = JsonSerializer.Deserialize<Employee>(resultString);
                return employee;
            }
            return null;
        }
        public List<Employee> GetAllEmployeesPerDepartment(String id)
        {
            List<Employee> employees = null;
            HttpResponseMessage response = client.GetAsync($"employees/department/{id}").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                employees = JsonSerializer.Deserialize<List<Employee>>(resultString);
                return employees;
            }
            return null;
        }
        public List<Employee> GetAllManagersPerDepartment(String id)
        {
            List<Employee> managers = null;
            HttpResponseMessage response = client.GetAsync($"employees/managers/department/{id}").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                managers = JsonSerializer.Deserialize<List<Employee>>(resultString);
                return managers;
            }
            return null;
        }

        public Employee AddEmployee(Employee employee)
        {
            HttpResponseMessage response = client.PostAsJsonAsync("employees", employee).Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Employee addedEmployee = JsonSerializer.Deserialize<Employee>(resultString);
                return addedEmployee;
            }
            return null;
        }

        public Employee UpdateEmployee(int id, Employee employee)
        {
            HttpResponseMessage response = client.PutAsJsonAsync($"employees/{id}", employee).Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Employee updatedEmployee = JsonSerializer.Deserialize<Employee>(resultString);
                return updatedEmployee;
            }
            return null;
        }

        public Employee RemoveEmployee(int id)
        {
            HttpResponseMessage response = client.DeleteAsync($"employees/{id}").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Employee removedEmployee = JsonSerializer.Deserialize<Employee>(resultString);
                return removedEmployee;
            }
            return null;
        }
    }
}
