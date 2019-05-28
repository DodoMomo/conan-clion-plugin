package conan.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import conan.ui.ConanToolWindow;

/**
 * Reload all Conan profiles tabs.
 *
 * Created by Yahav Itzhak on Feb 2018.
 */
public class ReloadProjectAction extends AnAction implements DumbAware {

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Project project = getEventProject(anActionEvent);
        ConanToolWindow conanToolWindow = ServiceManager.getService(project, ConanToolWindow.class);
        conanToolWindow.recreateContent(project);
    }

    @Override
    public void update(AnActionEvent anActionEvent) {
        Project project = anActionEvent.getProject();
        anActionEvent.getPresentation().setEnabledAndVisible(project != null);
    }
}