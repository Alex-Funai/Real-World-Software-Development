#Requires -Version 2.0||7.1
<#
  DIR2SEV.PS1

  .SYNOPSIS:
  Fucked up setting up dual boot, and had to convert drives to MBR, and then locked partitions like
  a noob. Had to reinstall. Made this incase it happens again. Would like to add querying function to
  the introduction that inputs common packages, then user's wouldn't have to edit script at all.
  
  .DESCRIPTION:
  Sets (SEV)"system-environment-variables\path" for my java dks.
  
  .REQUIRES:
  requires - powerShell-version-2.0||7.1.
  requires - admin console.
  requires - DACL && SACL access (for regedit).

.INPUTS: ($newSevEntries, $currentSevEntries, $updatedSevEntries).
  @param $newSevEntries ::list of SDK directories to add to your SEV.
  @param $currentSevEntries ::the current live SEV in -name path.
  @param $updatedSevEntries ::the updated SEV
  @param "SDK directories from (bin/home)s.""

.OUTPUTS:
  Updated SEV values in registry/system.

.NOTES:
  Version:        1.0
  Author:         <Alexander Funai>
  Creation Date:  <4/3/2021>

  Version:        2.0 (Sudo)
  1. Declare stack.
  2. Recursive search or filtered index through drives, and common default installation paths.
      + Get-ChildItem -Path <""> -filter @(*/bin, */jdk, */python, etc) -Exclude <"...">
  2. get the index items into queue with push. 
  3. Ask for input, if contains '3'= let all entries through, if not next step.
  3. while stack.isnotEmpty > stack.pop > ask for input > if contains "y" add to a new queue object, if "n" discard.
  4. save queue to $newSevEntries
  5. parse $newSevEntries through V1 app.

  Bonus:
  + Recursive search > selenium driver > place in correct dir.

.EXAMPLE:
Set the SDK home or bin directory in [A.1]. Include a semi-colon at the end of the entry.
#>


<# SCRIPT #>

<# [A.0 INTRODUCTION]:
#>  Write-Host "***********************************" 
    Write-Host "*       Welcome to DIR2SEV:       *"
    Write-Host "*                                 *"
    Write-Host "*  This program automates adding  *"
    Write-Host "*  SDK directories to my system   *"
    Write-Host "*  path environment variables     *"
    Write-Host "***********************************"
    Write-Host "*  Press any key and let the the  *"
    Write-Host "*  secret tunnels will guide you  *"
    Write-Host "***********************************"
    $x = $host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")


<# [B.0 DECLARATION SDKPENDENCE]: //initialize storage variables for the SDK directories:
#>  $newSevEntries = 

    <# 1::jdk:: #> @(
    "D:\Engineering\Java\JDK8\bin;"+
    "D:\Engineering\Java\JDK15\bin;"+
    
        <# 1.5::jre #>
        "D:\Engineering\Java\JRE\9;"+
    
            <# 2 ::python #>
            "D:\Engineering\Python;"+
        
                <# 3::gitBash #>
                "D:\Engineering\GIT\Git\bin;"+

                    <# 4::curL #>
                    "D:\Engineering\Curl\usr\bin;"+

                        <# 5::gradle #>
                        "D:\Engineering\Gradle\gradle-6.8.3-bin\gradle-6.8.3\bin;"+

                            <# 6::jnode #>
                            "D:\Engineering\NodeJS\node_modules\npm\bin;"+

                                <# 7::groovy #>
                                "D:\Engineering\Groovy\groovy-3.0.7\bin;"+

                                    <# 8::maven #>
                                    "D:\Engineering\Maven\apache-maven-3.6.3\bin;"+

                                        <# 9::androidStudio #>
                                        "D:\Engineering\AndroidStudio\AndroidStudio\bin;")
                                        <# End list with .split(";") to separate entries. #>


    <#  [C.0 PROCESS]: //initialize variable 4 current path-SEVs.
        HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Environment -Name Path
    #>  $currentSevEntries = [System.Environment]::GetEnvironmentVariable('Path','Machine')

        <#  [C.1 PROCESS]: //initialize updated SEV by adding old and new entries.
        #>  $updatedSevEntries = @($currentSevEntries + $newSevEntries)
        
            <#  [C.2 PROCESS]: //set the updated system-path entries:
            #>  [Environment]::SetEnvironmentVariable("Path", "$updatedSevEntries", "Machine")


                <#  [D.0 CONCLUSION]: //summary and stats.
                #>  $x = $host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")

                        Write-Host "****************************" 
                        Write-Host "*     Update complete:     *"
                        Write-Host "*                          *"
                        Write-Host "*     Item: 'System'       *"
                        Write-Host "*     Name: 'Path'         *"
                        Write-Host "*     Value: $updatedS-    *"
                        Write-Host "*            0evEntries    *"
                        Write-Host "****************************"
                        Write-Host ""
                        Write-Host "****************************"
                        Write-HOst "*   Verify and test the    *"
                        Write-Host "*   set registry value     *"
                        Write-Host "*   by pressing any key..  *"
                        Write-Host "*                          *"
                        Write-Host "*   Or feel free 2 /cd 2   *"
                        Write-Host "* HKLM\SYSTEM\CurrentCont- *"
                        Write-Host "* rolSet\Control\Session-  *"
                        Write-Host "* Manager\Environment\Path *"
                        Write-Host "****************************"

                        <# [D.1 CONCLUSION]: //Verify results:
                        $x = $host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
            
                            <#  [D.2 CONCLUSION]: //Verify|print current registry entries: 
                            #>  $test = Get-ItemPropertyValue -Path "HKLM:\SYSTEM\CurrentControlSet\Control\Session Manager\Environment" -Name Path
                                $test.Split(";")

                                <#  [E.0]: //Farewell:
                                #>  Write-Host "****************************"
                                    Write-Host "* Bye Bye            e    *"
                                    Write-Host "*   e        y    Bye Bye *" 
                                    Write-Host "*    b    Bye Bye    b    *"
                                    Write-Host "***************************"

                                    <# /SCRIPT #>
