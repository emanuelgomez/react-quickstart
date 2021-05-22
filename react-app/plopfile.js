module.exports = plop => {
  plop.setGenerator('component', {
    description: 'Create a component',
    // User input prompts provided as arguments to the template
    prompts: [
      {
        // Raw text input
        type: 'input',
        // Variable name for this input
        name: 'name',
        // Prompt to display on command line
        message: 'What is your component name?',
      }, {
        type: 'list',
        name: 'type',
        message: 'Is this a page or component?',
        choices: ['component', 'page'],
        default: 0,
      },
    ],
    actions: [
      {
        // Add a new file
        type: 'add',
        // Path for the new file
        path: 'src/{{type}}s/{{pascalCase name}}/{{pascalCase name}}.tsx',
        // Handlebars template used to generate content of new file
        templateFile: 'plop-templates/components/Component.tsx.hbs',
      },
      {
        // Add a new file
        type: 'add',
        // Path for the new file
        path: 'src/{{type}}s/{{pascalCase name}}/__tests__/{{pascalCase name}}.test.jsx',
        // Handlebars template used to generate content of new file
        templateFile: 'plop-templates/components/__tests__/Component.test.jsx.hbs',
      },
      {
        // Add a new file
        type: 'add',
        // Path for the new file
        path: 'src/{{type}}s/{{pascalCase name}}/index.ts',
        // Handlebars template used to generate content of new file
        templateFile: 'plop-templates/components/index.ts.hbs',
      },
      {
        type: 'append',
        path: 'src/{{type}}s/{{pascalCase name}}/index.ts',
        pattern: '/* PLOP_INJECT_EXPORT */',
        template: 'export { {{pascalCase name}} } from "./{{pascalCase name}}";',
      },
    ],
  });
};
