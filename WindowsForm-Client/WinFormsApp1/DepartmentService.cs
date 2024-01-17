using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace WinFormsApp1
{
    internal class DepartmentService
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

        public List<Department> GetAllDepartments()
        {
            List<Department> departments = null;
            HttpResponseMessage response = client.GetAsync("departments").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                departments = JsonSerializer.Deserialize<List<Department>>(resultString);
                return departments;
            }
            return null;
        }

        public Department GetDepartmentById(int id)
        {
            Department department = null;
            HttpResponseMessage response = client.GetAsync($"departments/{id}").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                department = JsonSerializer.Deserialize<Department>(resultString);
                return department;
            }
            return null;
        }

        public Department AddDepartment(Department department)
        {
            HttpResponseMessage response = client.PostAsJsonAsync("departments", department).Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Department addedDepartment = JsonSerializer.Deserialize<Department>(resultString);
                return addedDepartment;
            }
            return null;
        }

        public Department UpdateDepartment(int id, Department department)
        {
            HttpResponseMessage response = client.PutAsJsonAsync($"departments/{id}", department).Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Department updatedDepartment = JsonSerializer.Deserialize<Department>(resultString);
                return updatedDepartment;
            }
            return null;
        }

        public Department RemoveDepartment(int id)
        {
            HttpResponseMessage response = client.DeleteAsync($"departments/{id}").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Department removedDepartment = JsonSerializer.Deserialize<Department>(resultString);
                return removedDepartment;
            }
            return null;
        }
    }
}
