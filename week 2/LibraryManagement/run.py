import os
import urllib.request
import subprocess
import sys

# Dependencies
JARS = {
    "spring-core-5.3.30.jar": "https://repo1.maven.org/maven2/org/springframework/spring-core/5.3.30/spring-core-5.3.30.jar",
    "spring-context-5.3.30.jar": "https://repo1.maven.org/maven2/org/springframework/spring-context/5.3.30/spring-context-5.3.30.jar",
    "spring-beans-5.3.30.jar": "https://repo1.maven.org/maven2/org/springframework/spring-beans/5.3.30/spring-beans-5.3.30.jar",
    "spring-expression-5.3.30.jar": "https://repo1.maven.org/maven2/org/springframework/spring-expression/5.3.30/spring-expression-5.3.30.jar",
    "spring-aop-5.3.30.jar": "https://repo1.maven.org/maven2/org/springframework/spring-aop/5.3.30/spring-aop-5.3.30.jar",
    "spring-jcl-5.3.30.jar": "https://repo1.maven.org/maven2/org/springframework/spring-jcl/5.3.30/spring-jcl-5.3.30.jar"
}

def setup():
    if not os.path.exists("lib"):
        os.makedirs("lib")
    for filename, url in JARS.items():
        filepath = os.path.join("lib", filename)
        if not os.path.exists(filepath):
            print(f"Downloading {filename}...")
            urllib.request.urlretrieve(url, filepath)
        else:
            print(f"{filename} is ready")

def compile_and_run():
    if not os.path.exists("bin"):
        os.makedirs("bin")
    
    # Classpath separator (Windows uses ';', others use ':')
    cp_sep = ";" if os.name == "nt" else ":"
    
    # Gather jars for classpath
    jars = [os.path.join("lib", f) for f in os.listdir("lib") if f.endswith(".jar")]
    classpath = cp_sep.join(jars)
    
    # Run classpath needs bin, src/main/resources (for applicationContext.xml), and all jars
    run_classpath = cp_sep.join(["bin", "src/main/resources"] + jars)
    
    # Find all java source files
    java_files = []
    for root, dirs, files in os.walk("src"):
        for file in files:
            if file.endswith(".java"):
                java_files.append(os.path.join(root, file))
                
    if not java_files:
        print("No Java source files found!")
        sys.exit(1)
        
    # Compile
    print("\nCompiling Java source files...")
    cmd_compile = ["javac", "-d", "bin", "-cp", classpath] + java_files
    res = subprocess.run(cmd_compile)
    if res.returncode != 0:
        print("Compilation failed!")
        sys.exit(1)
    print("Compilation successful.")
    
    # Run
    print("\nRunning com.library.Main...")
    cmd_run = ["java", "-cp", run_classpath, "com.library.Main"]
    subprocess.run(cmd_run)

if __name__ == "__main__":
    setup()
    compile_and_run()
