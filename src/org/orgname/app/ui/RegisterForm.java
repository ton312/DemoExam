package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class RegisterForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField ageField;
    private JTextField jobField;
    private JButton backButton;
    private JButton registerButton;
    private JComboBox genderBox;

    public RegisterForm()
    {
        setContentPane(mainPanel);

        initElements();
        initButtons();

        setVisible(true);
    }

    private void initElements()
    {
        genderBox.addItem(GenderEnum.MALE);
        genderBox.addItem(GenderEnum.FEMALE);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new StartForm();
        });

        registerButton.addActionListener(e -> {
            try {
                UserEntity user = new UserEntity(
                        loginField.getText(),
                        new String(passwordField.getPassword()),
                        (GenderEnum)genderBox.getSelectedItem(),
                        Integer.parseInt(ageField.getText()),
                        jobField.getText()
                );
                userEntityManager.add(user);
                dispose();
                new MainForm(user);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 250;
    }
}

