const sequelize = require('../db')
const {datatypes, DataTypes} = require('sequelize')

const User = sequelize.define( 'user',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
        email: {type: DataTypes.STRING, unique: true},
        password: {type: DataTypes.STRING},
        role: {type: DataTypes.STRING, defaultValue: "USER"}
    }
)

const Basket = sequelize.define( 'user',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
    }
)
const BasketDevice = sequelize.define( 'user',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
    }
)
const Basket = sequelize.define( 'user',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
    }
)
