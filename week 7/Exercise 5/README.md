# Exercise 5: Git Cleanup and Remote Repository Synchronization

## Objectives & Detailed Explanation

1. **Understand Workspace Cleanup & Repository Hygiene**:
   - Before pushing updates to remote repositories, it is essential to inspect the working tree status (`git status`) to ensure there are no unintended untracked files, uncommitted changes, or broken submodules.
   - Cleaning up temporary development branches (`git branch -d`) ensures the repository remains structured, clutter-free, and easy for team members to navigate.

2. **Understand Pulling Latest Remote Changes (`git pull origin main`)**:
   - `git pull` fetches the latest commits from the remote repository (`origin/main`) and integrates/merges them into your local branch.
   - Performing a `git pull` prior to pushing ensures your local branch is synchronized with remote updates, preventing push rejections due to non-fast-forward state.

3. **Understand Remote Push & Verification (`git push origin main`)**:
   - `git push` uploads all local branch commits to the remote repository on GitHub/GitLab.
   - Verifying push completion ensures that all lab exercises and code modifications from `Git-T03-HOL_002` are successfully published and reflected on the remote repository.

---



## Exercise Steps & Commands

### Task Requirement
Verify master branch is in a clean state, list all local and remote branches, pull latest changes from the remote repository (`origin/main`), push all pending commits from `Git-T03-HOL_002` to the remote repository, and verify that changes are correctly reflected in the remote repository.

---

### Step-by-Step Instructions & Commands

#### 1. Verify `master` / `main` is in a clean state
Check the working tree status before synchronizing with the remote repository:
```bash
git status
```
*Actual Execution Output:*
```text
On branch main
Your branch is up to date with 'origin/main'.

nothing to commit, working tree clean
```

#### 2. List out all available local and remote branches
List all local branches and remote-tracking references:
```bash
git branch -a
```
*Actual Execution Output:*
```text
* main
  remotes/origin/main
```

#### 3. Pull latest updates from the remote Git repository
Fetch and merge any remote changes into the local trunk branch:
```bash
git pull origin main
```
*Actual Execution Output:*
```text
From https://github.com/Mayankg-13/cognizant-java-fse
 * branch            main       -> FETCH_HEAD
Already up to date.
```

#### 4. Push pending changes from `Git-T03-HOL_002` to remote repository
Upload local commits to the remote GitHub repository:
```bash
git push origin main
```
*Actual Execution Output:*
```text
To https://github.com/Mayankg-13/cognizant-java-fse.git
   f57ceba..42a5054  main -> main
```

#### 5. Verify changes are reflected in the remote repository
Run `git status` to confirm local branch is clean and fully synchronized with `origin/main`:
```bash
git status
```
*Actual Execution Output:*
```text
On branch main
Your branch is up to date with 'origin/main'.

nothing to commit, working tree clean
```

---

## Key Takeaways
1. Always run `git status` before pushing to ensure all desired files are committed and untracked files are cleaned up or ignored.
2. Always execute `git pull` before `git push` in collaborative environments to keep local branches updated with remote changes.
3. Successful `git push` publishes your commits to GitHub so that instructors and team members can view your completed work.
