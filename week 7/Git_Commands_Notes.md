# Exercise 1: Git Configuration & Basic Commands

## Objectives
- Familiar with Git commands like `git init`, `git status`, `git add`, `git commit`, `git push`, and `git pull`.
- Setup your machine with Git Configuration
- Integrate `notepad++.exe` to Git and make it a default editor
- Add a file to source code repository

## Prerequisites
- Install Git Bash client in your machine

> **Note:** Please follow the steps for creating a free account in GitHub. Don't use Cognizant credentials to login to GitHub.

---

## Step 1: Setup your machine with Git Configuration

To create a new repository, signup with GitLab/GitHub and register your credentials. Login to GitLab/GitHub and create a **GitDemo** project.

1. **Check if Git client is installed properly:**
   Open Git bash shell and execute:
   ```bash
   git version
   ```
   *Output:*
   ```text
   git version 2.21.0.windows.1
   ```

2. **Configure user level configuration of user ID and email ID:**
   ```bash
   git config --global user.name "username"
   git config --global user.email "username@cognizant.com"
   ```

3. **Check if the configuration is properly set:**
   ```bash
   git config --global --list
   ```
   *Output:*
   ```text
   user.name=username
   user.email=username@cognizant.com
   ```

---

## Step 2: Integrate notepad++.exe to Git and make it a default editor

1. **Check if notepad++.exe executes from Git bash:**
   ```bash
   notepad++
   ```
   *Output:*
   ```text
   bash: notepad++: command not found
   ```
   *(To add path of notepad++.exe to environment variable, go to Control Panel -> System -> Advanced system settings -> Go to Advanced tab -> Environment variables -> Add path of notepad++.exe to the path user variable by clicking on "Edit")*

2. **Exit Git bash shell, open bash shell and execute:**
   ```bash
   notepad++
   ```
   *(Now, notepad++ will open from Git bash shell)*

3. **Create an alias command for notepad++.exe:**
   ```bash
   notepad++.exe bash -profile
   ```
   Add the following line in Notepad++:
   ```bash
   alias npp='notepad++.exe -multiInst -nosession'
   ```

4. **Configure the editor:**
   ```bash
   git config --global core.editor "notepad++.exe -multiInst -nosession"
   ```

5. **Verify if notepad++ is the default editor:**
   ```bash
   git config --global -e
   ```
   *Output (Global Configuration):*
   ```ini
   [user]
       name = username
       email = username@cognizant.com
   [core]
       editor = notepad++.exe -multiInst -nosession
   ```

---

## Step 3: Add a file to source code repository

1. **Open Git bash shell and create a new project "GitDemo":**
   ```bash
   git init GitDemo
   ```
   *Output:*
   ```text
   Initialized empty Git repository in D:/Development_Avecto/GitDemo/.git/
   ```

2. **Verify repository directory contents:**
   ```bash
   ls -al
   ```
   *Output:*
   ```text
   drwxr-xr-x 1 ... .
   drwxr-xr-x 1 ... ..
   drwxr-xr-x 1 ... .git/
   ```

3. **Create file "welcome.txt" and add content:**
   ```bash
   echo "Welcome to the version control" >> welcome.txt
   ```

4. **Verify if file "welcome.txt" is created:**
   ```bash
   ls -al
   ```

5. **Verify file content:**
   ```bash
   cat welcome.txt
   ```
   *Output:*
   ```text
   Welcome to the version control
   ```

6. **Check repository status:**
   ```bash
   git status
   ```
   *Output:*
   ```text
   On branch master
   Untracked files:
     (use "git add <file>..." to include in what will be committed)

       welcome.txt
   ```

7. **Stage the file:**
   ```bash
   git add welcome.txt
   ```

8. **Commit the changes:**
   ```bash
   git commit
   ```

9. **Check if local working directory and repository are clean:**
   ```bash
   git status
   ```
   *Output:*
   ```text
   On branch master
   nothing to commit, working tree clean
   ```

10. **Signup with GitLab/GitHub and create a remote repository "GitDemo"**

11. **Pull remote repository:**
    ```bash
    git pull origin master
    ```

12. **Push local to remote repository:**
    ```bash
    git push origin master
    ```
