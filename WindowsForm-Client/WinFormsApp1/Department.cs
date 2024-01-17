using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Xml.XPath;

namespace WinFormsApp1
{
    internal class Department
    {
        public int id { get; set; }
        public string description { get; set; }
        public int parentId { get; set; }
    }
}
